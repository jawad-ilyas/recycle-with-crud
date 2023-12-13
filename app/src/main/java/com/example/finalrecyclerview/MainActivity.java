package com.example.finalrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonAdaptor.OnContactClicked {


    listFrag listShowFlag;
    Button btnASubmit;
    EditText etPhone, etName;
    FragmentManager manager;
    TextView tvDnumber , tvDName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         manager = getSupportFragmentManager();

        tvDnumber = manager.findFragmentById(R.id.fgDetailFrag).getView()
                .findViewById(R.id.tvDnumber);

        tvDName = manager.findFragmentById(R.id.fgDetailFrag).getView()
                .findViewById(R.id.tvDName);

        etPhone = manager.findFragmentById(R.id.fgDetailAdd).getView().findViewById(R.id.etPhone);
        etName = manager.findFragmentById(R.id.fgDetailAdd).getView().findViewById(R.id.etName);
        btnASubmit = manager.findFragmentById(R.id.fgDetailAdd).getView().findViewById(R.id.btnASubmit);

        btnASubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String number = etPhone.getText().toString().trim();

                ContactData.personArrayListData.add(new Person(name, number));
                listShowFlag.personAdaptor.notifyDataSetChanged();
                etName.setText("");
                etPhone.setText("");

            }
        });
    }

    @Override
    public void onClick(int index) {
        tvDnumber.setText(ContactData.personArrayListData.get(index).Number);
        tvDName.setText(ContactData.personArrayListData.get(index).Name);
    }
}