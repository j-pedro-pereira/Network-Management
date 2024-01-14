public class Frame {
    private int frameId;
    private String sourceMac;
    private String destMac;

    public Frame(int frameId, String sourceMac, String destMac) {
        this.frameId = frameId;
        this.sourceMac = sourceMac;
        this.destMac = destMac;
    }

    public int getFrameId() {
        return frameId;
    }

    public String getSourceMac() {
        return sourceMac;
    }

    public String getDestMac() {
        return destMac;
    }

    public void displayFrameInfo() {
        System.out.println("Frame Information:");
        System.out.println("Frame ID: " + frameId);
        System.out.println("Source MAC: " + sourceMac);
        System.out.println("Destination MAC: " + destMac);
    }
}
