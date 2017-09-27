package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        int WhippedCream = 0;
        int Chocolate = 0;
        if (WhippedCream()){
            WhippedCream = quantity;
        }
        if (Chocolate()){
            Chocolate = quantity * 2;
        }

        return quantity * cuprice + WhippedCream + Chocolate;
    }

    public void increment (View view){
        quantity = quantity + 1;
        if (quantity >= 101){
            quantity = 100;
            Context context = getApplicationContext();
            CharSequence text = "Max of Coffes: 100!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        displayQuantity(quantity);
    }

    public void decrement (View view){
        quantity = quantity - 1;
        if (quantity <= 0){
            quantity = 1;
            Context context = getApplicationContext();
            CharSequence text = "Min of Coffes: 1!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }
        displayQuantity(quantity);
    }


    public String name(){
        EditText name = (EditText) findViewById(R.id.et_name);
        String personName = name.getText().toString();
        return personName;
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




    /**
     * Cria um resumo da ordem.
     *
     * @param WhippedCream é se ou não o usuário quer coberta de chantilly
     * @param Chocolate é se ou não o usuário quer cobertura de chocolate
     * @param quantity quantidade da ordem
     * @return resumo do texto
     */

    private String createOrderSummary(int quantity, boolean WhippedCream, boolean Chocolate){
        int price = calculatePrice(quantity, 5);
        String name = name();
        String orderSummary = "Name: " + name;
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


