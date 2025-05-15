package lipid;

public enum LipidClassRank {
    PG(1),
    PE(2),
    PI(3),
    PA(4),
    PS(5),
    PC(6),
    UNKNOWN(999);

    private final int rank;

    LipidClassRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static int getRankForType(String type) {
        try {
            return LipidClassRank.valueOf(type).getRank();
        } catch (IllegalArgumentException e) {
            return UNKNOWN.getRank();
        }
    }
}
