package Models;

public class TransactionList {

    private Transaction[] data;
    private Integer lastPage;

    public Transaction[] getData() {
        return data;
    }

    public void setData(Transaction[] data) {
        this.data = data;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }
}