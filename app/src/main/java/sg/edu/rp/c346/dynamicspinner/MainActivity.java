package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button BtnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnUpdate = findViewById(R.id.buttonUpdate);
        spn1 = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);

        //BtnUpdate.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                alNumbers.clear();
                switch (i){
                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.even_number);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        aaNumbers.notifyDataSetChanged();
                        spn2.setSelection(3);
                        break;
                    case 1:
                        String[] oddNumbers = getResources().getStringArray(R.array.odd_number);
                        alNumbers.addAll(Arrays.asList(oddNumbers));
                        aaNumbers.notifyDataSetChanged();
                        spn2.setSelection(2);
                        break;
            }




        }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            });


        alNumbers = new ArrayList<>();


        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        spn2.setAdapter(aaNumbers);





    }
}
