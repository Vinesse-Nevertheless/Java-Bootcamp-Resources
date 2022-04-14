class DrawingFactory {
    public Drawing createDrawing(int choice) {
        switch (choice) {
            case 1:
                return new Butterfly();
            case 2:
                return new Elephant();
            case 3:
                return new Bear();
            case 4:
                return new Snake();
            default:
                throw new IllegalArgumentException("No drawing for this number choice.");
        }
    }
}
