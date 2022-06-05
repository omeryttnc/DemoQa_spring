package QA.Enums;

public enum DeliveryCost {
    $15(0, 49),
    $10(50, 74),
    $5(75, Integer.MAX_VALUE);


    private int max;
    private int min;

    DeliveryCost(int min, int max) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public static String teslim(int fiyat) {
        String  deliveryCost = "";
        for (DeliveryCost w : values()) {
            if (fiyat < w.max && fiyat > w.min) {
                deliveryCost = w.name();
            }

        }

        return deliveryCost;
    }
}
