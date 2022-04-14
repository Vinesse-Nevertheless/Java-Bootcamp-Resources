public enum MagicNumbers {
    GAMEOVER (6), ZEROPOINTS (4);

    private int value;

    MagicNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
