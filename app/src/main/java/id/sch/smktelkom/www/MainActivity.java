package id.sch.smktelkom.www;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    EditText nama, tempatlahir, alamat, hobi, minat;
    Spinner jkelamin;
    Button tanggallahir, submit;
    TextView biodatadiri;
    private int mTahun, mBulan, mHari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.edt_nama);
        tempatlahir = findViewById(R.id.edt_tempatLahir);
        alamat = findViewById(R.id.edt_alamat);
        hobi = findViewById(R.id.edt_hobi);
        minat = findViewById(R.id.edt_minat);

        jkelamin = findViewById(R.id.spn_jkelamin);

        tanggallahir = findViewById(R.id.btn_tanggalLahir);
        submit = findViewById(R.id.btn_submit);

        biodatadiri = findViewById(R.id.txt_biodatadiri);

        List<String> ListKelamin = new ArrayList<String>();
        ListKelamin.add("Laki-laki");
        ListKelamin.add("Perempuan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ListKelamin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jkelamin.setAdapter(adapter);

        tanggallahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                mTahun = cal.get(Calendar.YEAR);
                mBulan = cal.get(Calendar.MONTH);
                mHari = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDateDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        tanggallahir.setText(dayOfMonth+"-"+month+"-" +year);

                    }
                },mTahun, mBulan, mHari);
                mDateDialog.setTitle("Pilih Tanggal Lahir");
                mDateDialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biodatadiri.setText("Namaku " +nama.getText().toString()+ ", Aku lahir di " +tempatlahir.getText().toString()+ ", Pada tanggal " +tanggallahir.getText().toString()+ ", Alamat rumahku ada di " +alamat.getText().toString()+
                        ", Aku memiliki hobi " +hobi.getText().toString()+ " dan Minatku adalah " +minat.getText().toString()+ ". Senang Berkenalan Denganmu !! THANK YOU !!");
            }
        });


    }
}