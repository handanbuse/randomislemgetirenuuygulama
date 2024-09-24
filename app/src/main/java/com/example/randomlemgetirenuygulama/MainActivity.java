package com.example.randomlemgetirenuygulama;


//import static com.example.randomlemgetirenuygulama.R.id.buttonsorugetir;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggletopla, togglecarp, toggleböl,togglecıkar;
    private TextView txtsoru;
    private EditText edittxttahmin;
    private ArrayList<String > islemtürleri;
    private Random rndIslem, rndsayi;
    private int rndislemtürü, rndsayinumber;
    String soru ,txtTahmin;
    private int s1,s2,sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        islemtürleri=new ArrayList<>();
        toggleböl=findViewById(R.id.toggleButtonböl);
        togglecarp=findViewById(R.id.toggleButtoncarp);
        togglecıkar=findViewById(R.id.toggleButtoncıkar);
        toggletopla=findViewById(R.id.toggleButtonTopla);
        edittxttahmin=findViewById(R.id.edittxttahmin);
        txtsoru=findViewById(R.id.txtsoru);

        rndIslem=new Random();
        rndsayi= new Random();


        toggletopla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    islemtürleri.add("+");
                else
                    islemtürleri.remove("+");
            }
        });

        toggleböl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    islemtürleri.add("/");
                else
                    islemtürleri.remove("/");
            }
        });
        togglecıkar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    islemtürleri.add("-");
                else islemtürleri.remove("-");

            }
        });
        togglecarp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    islemtürleri.add("*");
                else
                    islemtürleri.remove("*");
            }
        });

    }
    public void btnClick(View  v){
        if(v.getId()==R.id.buttonsorugetir){
            txtsoru.setText(Islemturunuvesoruyubelirle());
        }
        else if (v.getId() == R.id.buttontahmin) {
            // Tahmin işlemleri
        }


    }


    private void tahminkontrol(){

        txtTahmin=edittxttahmin.getText().toString();

        if(!TextUtils.isEmpty(txtTahmin)){
            if (txtTahmin.matches(String.valueOf(sonuc))){
                System.out.println("tebrikler sonuc doğru");
                edittxttahmin.setText("");
                txtsoru.setText(Islemturunuvesoruyubelirle());

            }
            else System.out.println("yanlış tahminde bulundunuz");

        } else System.out.println("boş olamaz");

    }

    private String Islemturunuvesoruyubelirle(){

        soru= " ";
     if (islemtürleri.size()>0){
         rndislemtürü=rndIslem.nextInt(islemtürleri.size());

         s1=randomsayigetir();
         soru +=s1;
         soru +=" ";

         soru += islemtürleri.get(rndsayinumber);
         soru+=" ";
         s2=randomsayigetir();
         soru +=s2;

          switch (islemtürleri.get(rndislemtürü)){
             case "+":
                 sonuc= s1+s2;
                 break;
             case "-":
                 sonuc= s1-s2;
                 break;
             case "+/":
                 sonuc= s1/s2;
                 break;
             case "*":
                 sonuc= s1*s2;
                 break;
         }


     }
        return soru;

    }

    private int randomsayigetir(){
        rndsayinumber= rndsayi.nextInt(10)+1;
        return rndsayinumber;


    }


}