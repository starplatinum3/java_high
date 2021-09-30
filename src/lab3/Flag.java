package lab3;

public class Flag {
    int quatationFlag = 0;
    int cmtFlag = 0;
    int lineCmtFlag = 0;

    public int getQuatationFlag() {
        return quatationFlag;
    }

    public void setQuatationFlag(int quatationFlag) {
        this.quatationFlag = quatationFlag;
    }

    public int getCmtFlag() {
        return cmtFlag;
    }

    public void setCmtFlag(int cmtFlag) {
        this.cmtFlag = cmtFlag;
    }

    public int getLineCmtFlag() {
        return lineCmtFlag;
    }

    public void setLineCmtFlag(int lineCmtFlag) {
        this.lineCmtFlag = lineCmtFlag;
    }

    public Flag(int quatationFlag, int cmtFlag, int lineCmtFlag) {
        this.quatationFlag = quatationFlag;
        this.cmtFlag = cmtFlag;
        this.lineCmtFlag = lineCmtFlag;
    }
}
