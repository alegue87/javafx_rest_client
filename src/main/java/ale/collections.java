package ale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Product
 */
class Product extends Base {
    public String model;
    public int quantity;
    public double price;
    public String image;
}

/**
 * Products
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Products {
    //public String public;
    public Product[] data;
}

/**
 * Base collection
 */
class Base {
    public int id;
    public String status;
    public int owner; // id
    public String created_on;
}


/**
 * auth
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Auth {
    public String data;
}
