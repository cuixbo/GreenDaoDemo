package demo.cxb.com.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class Book {
    @Id(autoincrement = true)
    public Long id;
    @Property(nameInDb = "book_name")
    @NotNull
    public String name;
    @Property
    public double price;
    @Property
    public int onSale;
    @Property
    public float salePrice;
    @Property
    public String profit;

    @Generated(hash = 1322795641)
    public Book(Long id, @NotNull String name, double price, int onSale,
            float salePrice, String profit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.onSale = onSale;
        this.salePrice = salePrice;
        this.profit = profit;
    }

    @Generated(hash = 1839243756)
    public Book() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

 

    public int getOnSale() {
        return this.onSale;
    }

    public void setOnSale(int onSale) {
        this.onSale = onSale;
    }

    public float getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", onSale=" + onSale +
                ", salePrice=" + salePrice +
                ", profit='" + profit + '\'' +
                '}';
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProfit() {
        return this.profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }
}
