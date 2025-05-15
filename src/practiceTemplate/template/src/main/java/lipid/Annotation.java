package lipid;

import adduct.Adduct;
import adduct.AdductList;
import java.util.*;



/*
Una Annotation es una observación concreta de un lípido en tus datos experimentales, con toda la información asociada:
su masa, su intensidad, el tipo de ion que formó (aducto), y otros picos relacionados.
*/

public class Annotation {

    private final Lipid lipid;
    private final double mz;
    private final double intensity;
    private final double rtMin;
    private IoniationMode ionizationMode;
    private String adduct;
    private final Set<Peak> groupedSignals;
    private int score;
    private int totalScoresApplied;

    public Annotation(Lipid lipid, double mz, double intensity, double retentionTime, IoniationMode ionizationMode) {
        this(lipid, mz, intensity, retentionTime, Collections.emptySet(), ionizationMode);
    }


    public Annotation(Lipid lipid, double mz, double intensity, double retentionTime, Set<Peak> groupedSignals,IoniationMode ionizationMode) {
        this.lipid = lipid;
        this.mz = mz;
        this.rtMin = retentionTime;
        this.intensity = intensity;
        this.groupedSignals = new TreeSet<>(groupedSignals);
        this.ionizationMode = ionizationMode;
        detectAdduct();
        this.score = 0;
        this.totalScoresApplied = 0;
    }

    public Lipid getLipid() {
        return lipid;
    }

    public double getMz() {
        return mz;
    }

    public double getRtMin() {
        return rtMin;
    }

    public String getAdduct() {
        return adduct;
    }

    public void setAdduct(String adduct) {
        this.adduct = adduct;
    }

    public double getIntensity() {
        return intensity;
    }

    public Set<Peak> getGroupedSignals() {
        return Collections.unmodifiableSet(groupedSignals);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IoniationMode getIonizationMode() {return ionizationMode;}

    public void setIonizationMode(IoniationMode ionizationMode) {this.ionizationMode = ionizationMode;}

    public void addScore(int delta) {
        this.score += delta;
        this.totalScoresApplied++;
    }

    public double getNormalizedScore() {
        if (totalScoresApplied == 0) return 0.0;
        // Normaliza el score: promedio entre los deltas, acotado entre -1 y 1
        double normalized = (double) score / totalScoresApplied;
        return Math.max(-1.0, Math.min(1.0, normalized));
    }

    public int getCarbonCount() {
        return lipid.getCarbonCount();
    }

    public String getLipidType() {
        return lipid.getLipidType();
    }

    public int getDoubleBondCount() {
        return lipid.getDoubleBondCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Annotation that)) return false;
        return Double.compare(that.mz, mz) == 0 &&
                Double.compare(that.rtMin, rtMin) == 0 &&
                Objects.equals(lipid, that.lipid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lipid, mz, rtMin);
    }

    @Override
    public String toString() {
        return String.format("Annotation(%s, mz=%.4f, RT=%.2f, adduct=%s, intensity=%.1f, score=%d, norm=%.2f)",
                lipid.getName(), mz, rtMin, adduct, intensity, score, getNormalizedScore());
    }


    private void detectAdduct() {
        if (groupedSignals.isEmpty()) return;

        double bestTolerance = 0.02;

        Map<String, String> adductMap;
        String ionMode;

        if (ionizationMode == IoniationMode.POSITIVE) {
            adductMap = AdductList.MAPMZPOSITIVEADDUCTS;
            ionMode = "positive";
        } else {
            adductMap = AdductList.MAPMZNEGATIVEADDUCTS;
            ionMode = "negative";
        }

        this.adduct = detectFromMap(adductMap, ionMode, bestTolerance);
    }


    private String detectFromMap(Map<String, String> adductMap, String ionMode, double tolerance) {

        for (Peak peak1 : groupedSignals) {
            for (String adductName1 : adductMap.keySet()) {
                double massShift1 = Double.parseDouble(adductMap.get(adductName1));
                Adduct adductObj1 = new Adduct(adductName1, massShift1, ionMode, peak1.getMz());
                double neutralMass = adductObj1.getMonoisotopicMass();

                for (Peak peak2 : groupedSignals) {
                    if (peak1 == peak2) continue;

                    for (String adductName2 : adductMap.keySet()) {
                        double massShift2 = Double.parseDouble(adductMap.get(adductName2));
                        Adduct adductObj2 = new Adduct(adductName2, massShift2, ionMode);

                        double expectedMz2 = Adduct.calculateExpectedMzFromNeutralMass(neutralMass, adductObj2);

                        double diff = Math.abs(peak2.getMz() - expectedMz2);

                        if (diff <= tolerance) {
                            return adductName1;
                        }
                    }
                }
            }
        }

        return null; // No se detectó nada en este modo
    }


}