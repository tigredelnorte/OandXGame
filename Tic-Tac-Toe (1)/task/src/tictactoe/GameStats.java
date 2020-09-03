package tictactoe;

public class GameStats {
    int xCount;
    int oCount;
    int emptyCount;
    int x3s;
    int o3s;

    public void addXCount() {
        this.xCount++;
    }

    public void addOCount() {
        this.oCount++;
    }

    public void addEmptyCount() {
        this.emptyCount++;
    }

    public void addX3s() {
        this.x3s++;
    }

    public void addO3s() {
        this.o3s++;
    }

    public int getxCount() {
        return xCount;
    }

    public void setxCount(int xCount) {
        this.xCount = xCount;
    }

    public int getoCount() {
        return oCount;
    }

    public void setoCount(int oCount) {
        this.oCount = oCount;
    }

    public int getEmptyCount() {
        return emptyCount;
    }

    public void setEmptyCount(int emptyCount) {
        this.emptyCount = emptyCount;
    }

    public int getX3s() {
        return x3s;
    }

    public void setX3s(int x3s) {
        this.x3s = x3s;
    }

    public int getO3s() {
        return o3s;
    }

    public void setO3s(int o3s) {
        this.o3s = o3s;
    }

    @Override
    public String toString() {
        return "ArrayStats{" +
                "xCount=" + xCount +
                ", oCount=" + oCount +
                ", emptyCount=" + emptyCount +
                ", x3s=" + x3s +
                ", o3s=" + o3s +
                '}';
    }

    public void setToZero() {
        this.xCount = 0;
        this.oCount = 0;
        this.emptyCount = 0;
        this.x3s = 0;
        this.o3s = 0;
    }
}
