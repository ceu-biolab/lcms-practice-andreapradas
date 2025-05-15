package adduct;

import lipid.Peak;

import java.util.Objects;

public class Adduct {

    private  String name;
    private  int charge;
    private  int multimer;
    private  double massShift;
    private  String ionizationMode; // "positive" o "negative"
    private  double monoisotopicMass;
    private  String definition;
    private double mz;

    public Adduct(String name, double massShift, String ionizationMode, double mz) {
        this.name = name;
        this.massShift = massShift;
        this.ionizationMode = ionizationMode;
        this.charge = parseCharge(name);
        this.multimer = parseMultimer(name);
        this.mz=mz;
        this.monoisotopicMass = calculateMonoisotopicMassFromMZ(mz);
        this.definition = generateDefinition();
    }
    public Adduct(String name, double massShift, String ionizationMode) {
        this.name = name;
        this.massShift = massShift;
        this.ionizationMode = ionizationMode;
        this.charge = parseCharge(name);
        this.multimer = parseMultimer(name);
        this.definition = generateDefinition();
    }

    public String getName() {
        return name;
    }

    public int getCharge() {
        return charge;
    }

    public int getMultimer() {
        return multimer;
    }

    public String getDefinition() {
        return definition;
    }

    public double getMonoisotopicMass() {
        return monoisotopicMass;
    }

    public double getMassShift() {
        return massShift;
    }

    public String getIonizationMode() {
        return ionizationMode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public void setMultimer(int multimer) {
        this.multimer = multimer;
    }

    public void setMassShift(double massShift) {
        this.massShift = massShift;
    }

    public void setIonizationMode(String ionizationMode) {
        this.ionizationMode = ionizationMode;
    }

    public void setMonoisotopicMass(double monoisotopicMass) {
        this.monoisotopicMass = monoisotopicMass;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public double getMz() {
        return mz;
    }

    public void setMz(double mz) {
        this.mz = mz;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Adduct adduct = (Adduct) o;
        return charge == adduct.charge && multimer == adduct.multimer && Double.compare(massShift, adduct.massShift) == 0 && Double.compare(monoisotopicMass, adduct.monoisotopicMass) == 0 && Objects.equals(name, adduct.name) && Objects.equals(ionizationMode, adduct.ionizationMode) && Objects.equals(definition, adduct.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, charge, multimer, massShift, ionizationMode, monoisotopicMass, definition);
    }

    private int parseCharge(String name) {
        if (name.contains("3+")) return 3;
        if (name.contains("2+")) return 2;
        if (name.contains("3−") || name.contains("3-")) return 3;
        if (name.contains("2−") || name.contains("2-")) return 2;
        return 1;
    }

    private int parseMultimer(String name) {
        if (name.startsWith("[2M")) return 2;
        if (name.startsWith("[3M")) return 3;
        return 1;
    }
    private double calculateMonoisotopicMassFromMZ(double mz) {
        return (mz * charge * multimer) + (massShift * charge);
    }

    public static double calculateExpectedMzFromNeutralMass(double neutralMass, Adduct adduct) {
        int charge = adduct.getCharge();
        int multimer = adduct.getMultimer();
        double shift = adduct.getMassShift();

        return (neutralMass - (shift * charge)) / (charge * multimer);
    }

    private String generateDefinition() {
        return String.format("Adduct %s (%s mode), charge=%d, multimer=%d",
                name, ionizationMode, charge, multimer);
    }


    @Override
    public String toString() {
        return String.format("Adduct{name='%s', monoMass=%.4f, charge=%d, multimer=%d}", name, monoisotopicMass, charge, multimer);
    }
    /**
     * Returns the ppm difference between measured mass and theoretical mass
     *
     * @param experimentalMass    Mass measured by MS
     * @param theoreticalMass Theoretical mass of the compound
     */
    public static int calculatePPMIncrement(Double experimentalMass, Double theoreticalMass) {
        int ppmIncrement;
        ppmIncrement = (int) Math.round(Math.abs((experimentalMass - theoreticalMass) * 1000000
                / theoreticalMass));
        return ppmIncrement;
    }

    /**
     * Returns the ppm difference between measured mass and theoretical mass
     *
     * @param measuredMass    Mass measured by MS
     * @param ppm ppm of tolerance
     */
    public static double calculateDeltaPPM(Double experimentalMass, int ppm) {
        double deltaPPM;
        deltaPPM =  Math.round(Math.abs((experimentalMass * ppm) / 1000000));
        return deltaPPM;
    }
}
