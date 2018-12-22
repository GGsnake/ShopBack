package com.zyqhw.springboot.util;


import java.io.Serializable;
import java.util.List;


/**
 * 
 * @author daiwenhua
 *
 */
public class PageResult<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7166813722986868206L;

	int pageNo;
	
	int pageSize;
	
	int recordCount;
	
	int pageCount;
	
	int startRow;
	
	int endRow;
	
	List<T> rows;
	
	public PageResult(){}
	
	public PageResult(PageParam param){
		this.pageNo = param.getPageNo();
		this.pageSize = param.getPageSize();
		this.startRow = param.getStartRow();
		this.endRow = param.getEndRow();
	}
	
	protected int carculatePageCount(int recordCount){
		if(recordCount == 0){
			return 0;
		}
		return recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		this.pageCount = carculatePageCount(recordCount);
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
}
