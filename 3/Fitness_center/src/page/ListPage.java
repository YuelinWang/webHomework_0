package page;

import java.util.ArrayList;
import java.util.List;

public class ListPage {
	private boolean page=false;
    private List listData = new ArrayList();
    private Integer beginIndex=0, count = 0, preIndex = 0, nextIndex = 0;
    private Integer pageSize = 1;

    public boolean isPage() {
        return page;
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public List getListData() {
        return listData;
    }

    public void setListData(List listData) {
        this.listData = listData;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPreIndex() {
        return preIndex;
    }

    public void setPreIndex(Integer preIndex) {
        this.preIndex = preIndex;
    }

    public Integer getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(Integer nextIndex) {
        this.nextIndex = nextIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}       
