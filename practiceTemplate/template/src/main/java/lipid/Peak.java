package lipid;

//Representa un pico individual en un espectro de masas

public class Peak implements Comparable<Peak> { //  agregado Comparable<Peak>. Los objetos Peak se pueden comparar entre sí. Porque se usa un TreeSet<Peak> en tu clase Annotation, y un TreeSet necesita saber cómo ordenar sus elementos.

    private final double mz;
    private final double intensity;

    public Peak(double mz, double intensity) {
        this.mz = mz;
        this.intensity = intensity;
    }

    public double getMz() {
        return mz;
    }

    public double getIntensity() {
        return intensity;
    }

    @Override
    public int compareTo(Peak other) {
        // Comparamos por intensidad de mayor a menor
        return -Double.compare(this.intensity, other.intensity);
    }

    @Override
    public String toString() {
        return String.format("Peak(mz=%.4f, intensity=%.2f)", mz, intensity);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(mz) * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Peak other)) return false;
        return Double.compare(mz, other.mz) == 0;
    }
}
