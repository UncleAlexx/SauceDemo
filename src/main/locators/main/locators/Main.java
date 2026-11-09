package main.locators;


public class Main {

    public static void main() {
        System.out.println(CssSelectors.allCssLocatorsExist() && PrimitiveSelectors.allPrimitiveLocatorsExist() &&
        XPathSelectors.allXpathLocatorsExist());
    }
}
