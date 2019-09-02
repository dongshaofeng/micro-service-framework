package arterycloud.common.bean;



import java.util.List;

public class PageInfo<T> {
	
	//过滤条件
	private T filterObj;
	//过滤条件
	private List<Filter> filterList;
	//排序条件
	private List<Sort> sortList;
	//每页条数
	private int limit;
	//偏移量
	private int offset;
	//总页数
	private int pageCount;
	//总条数
	private int rowCount;
	//是否分页
	private boolean splitPage;
	
	public T getFilterObj() {
		return filterObj;
	}
	public void setFilterObj(T filterObj) {
		this.filterObj = filterObj;
	}
	public List<Filter> getFilterList() {
		return filterList;
	}
	public void setFilterList(List<Filter> filterList) {
		this.filterList = filterList;
	}
	public List<Sort> getSortList() {
		return sortList;
	}
	public void setSortList(List<Sort> sortList) {
		this.sortList = sortList;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public boolean getSplitPage() {
		return splitPage;
	}
	public void setSplitPage(boolean splitPage) {
		this.splitPage = splitPage;
	}

}
