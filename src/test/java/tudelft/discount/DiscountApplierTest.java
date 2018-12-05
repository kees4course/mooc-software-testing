package tudelft.discount;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class DiscountApplierTest implements ProductDao {

    /* ------------------ The mocks -------------------------- */

    protected List<Product> product_list;   /* The mocked storage of the products */
    final boolean use_memory_mock = true;   /* Use the in memory mock */


    /***
     * Implementation in which the data is mapped in memory
     * @return
     */
    protected List<Product> all_memory() {
        if (product_list==null) {
            return new ArrayList<Product>();
        } else {
            return product_list;
        }
    }

    /**
     * Implementation in which the data is mapped external
     * @return
     */
    protected List<Product> all_external() {
        List<Product> result = new ArrayList<Product>();

        if (product_list!=null) {
            for (Product product: product_list) {
                result.add(product);
            }
        }

        return result;
    }

    public List<Product> all() {
        if (use_memory_mock) {
            return all_memory();
        } else {
            return all_external();
        }
    }

    /* ------------------ Supporting the tests ----------------- */


    /***
     * Returns if the amount first and second are less than 0.005
     * @param first
     * @param second
     * @return
     */
    static boolean AmountEqual(double first, double second) {
        boolean result = false;
        int first_cents = Math.toIntExact(Math.round(first*10.0f));
        int second_cents = Math.toIntExact(Math.round(second*10.0f));

        if (first_cents==second_cents) {
            result = true;
        }
        return result;
    }

    /* -------------------- The tests ----------------------------*/

    @ParameterizedTest
    @CsvSource({
            "home,100.00,HOME,90.00",
            "business,100.00,BUSINESS,110.00",
            "cents_home,0.01,HOME,0.01",
            "cents_business,0.01,BUSINESS,0.01",
            "roundup_home,5.55,HOME,5.00",
            "rounddown_home,5.56,HOME,5.00"
    })
    void TestProductDaoMock(String sName,double dAmount, String sCategory, double result) {
        try {
            DiscountApplier discount_applier = new DiscountApplier(this);
            Product product = new Product(sName,dAmount,sCategory);

            product_list = new ArrayList<Product>();
            product_list.add(product);

            discount_applier.setNewPrices();

            Assertions.assertTrue(AmountEqual(product.getPrice(),result));
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }



}
