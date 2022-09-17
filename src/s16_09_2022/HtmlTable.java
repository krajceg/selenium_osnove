package s16_09_2022;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HtmlTable {

	private WebElement table;
	private WebDriver driver;

	public HtmlTable(WebElement table, WebDriver driver) {
		super();
		this.table = table;
		this.driver = driver;
	}

	public String getCellText(int row, int cell) {
		List<WebElement> rows = this.table.findElements(By.tagName("tr"));
		List<WebElement> cells = null;
		if (row == 0) {
			cells = rows.get(row).findElements(By.tagName("th"));
		} else {
			cells = rows.get(row).findElements(By.tagName("td"));
		}

		return cells.get(cell).getText();
	}

	public List<WebElement> getColumnsByName(String imeKolone) {
		List<WebElement> celijePrint = new ArrayList<WebElement>();
		List<WebElement> rows = this.table.findElements(By.tagName("tr"));
		List<WebElement> cellsTh = rows.get(0).findElements(By.tagName("th"));

		int indexCelije = 0;

		for (int i = 0; i < cellsTh.size(); i++) {
			if (cellsTh.get(i).getText().equals(imeKolone)) {
				indexCelije = i;
			}
		}

		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			celijePrint.add(cells.get(indexCelije));
		}

		return celijePrint;
	}

	public void sortDescending(String imeKolone) throws InterruptedException {
		List<WebElement> rows = this.table.findElements(By.tagName("tr"));
		List<WebElement> cellsTh = rows.get(0).findElements(By.tagName("th"));

		for (int i = 0; i < cellsTh.size(); i++) {
			if (cellsTh.get(i).getText().equals(imeKolone)) {
				do {
					new Actions(driver).moveToElement(cellsTh.get(i)).click().perform();
				} while (!cellsTh.get(i).getAttribute("class").equals("header headerSortDown"));
			}
		}
	}
	
	public void sortAscending(String imeKolone) throws InterruptedException {
		List<WebElement> rows = this.table.findElements(By.tagName("tr"));
		List<WebElement> cellsTh = rows.get(0).findElements(By.tagName("th"));

		for (int i = 0; i < cellsTh.size(); i++) {
			if (cellsTh.get(i).getText().equals(imeKolone)) {
				do {
					new Actions(driver).moveToElement(cellsTh.get(i)).click().perform();
				} while (!cellsTh.get(i).getAttribute("class").equals("header headerSortUp"));
			}
		}
	}
	
	

}
