package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;
    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    private void displayMessage (String message){
        TextView orderSummaryTextView= (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(int quantity, int cuprice){
        return quantity * cuprice;
    }

    public void increment (View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement (View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public boolean WhippedCream(){
        CheckBox whipped = (CheckBox) findViewById(R.id.cb_whipped_cream);
        boolean WhippedCream =  whipped.isChecked();
        Log.v("MainActivity", "Has Whipped Cream? " + WhippedCream);
        return WhippedCream;
    }

    public boolean Chocolate(){
        CheckBox chocolate = (CheckBox) findViewById(R.id.cb_chocolate);
        boolean cbChocolate = chocolate.isChecked();
        return cbChocolate;
    }

    private String createOrderSummary(int quantity, boolean WhippedCream, boolean Chocolate){
        int price = calculatePrice(quantity, 5);
        String orderSummary = "Name: Leonardo Marciano";
        orderSummary += "\nAdd Whipped Cream? " + WhippedCream; //bool WhippedCream
        orderSummary += "\n Add Chocolate? " + Chocolate;
        orderSummary += "\nQuantity = " + quantity; // quantity
        orderSummary += "\nTotal= U$ " + price; // price
        orderSummary += "\n Thanks you!!";
        return orderSummary;
    }

    public void submitOrder(View view){
        boolean cbWhippedCream = WhippedCream();
        boolean chocolate = Chocolate();
        String order = createOrderSummary(quantity, cbWhippedCream, chocolate);
        displayMessage(order);
    }

}


