package com.khendec.rathana.chipsview_chipsinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.doodle.android.chips.ChipsView;
import com.khendec.rathana.chipsview_chipsinput.adapter.ContactAdapter;
import com.khendec.rathana.chipsview_chipsinput.entity.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChipsViewActivity extends AppCompatActivity {

    @BindView(R.id.cv_contact)
    ChipsView cvContact;
    @BindView(R.id.contact_rc)
    RecyclerView rcContact;
    List<Contact> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips_view);
        ButterKnife.bind(this);

        list=getContactList();
        ContactAdapter adapter=new ContactAdapter(list,this);
        rcContact.setLayoutManager(new LinearLayoutManager(this));
        rcContact.setAdapter(adapter);
    }


    public List<Contact> getContactList(){
        List<Contact> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Contact("099 42 77 76", "Rathana "+i));
        }
        return list;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
