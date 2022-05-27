public class List {
    private boolean check;

    private int[] list;


    public List(int[] list, boolean check) {
        this.list = list;
        this.check = true;
    }

    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }
}
