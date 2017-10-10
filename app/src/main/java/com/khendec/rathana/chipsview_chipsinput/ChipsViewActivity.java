package com.khendec.rathana.chipsview_chipsinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.doodle.android.chips.ChipsView;
import com.khendec.rathana.chipsview_chipsinput.adapter.ContactAdapter;
import com.khendec.rathana.chipsview_chipsinput.entity.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChipsViewActivity extends AppCompatActivity {

    ChipsView cvContact;
    RecyclerView rcContact;
    ContactAdapter adapter;
    List<Contact> list= new ArrayList<>();
    List<Contact> tempList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips_view);
        //ButterKnife.bind(this);
        rcContact= (RecyclerView) findViewById(R.id.rc_contact);
        cvContact= (ChipsView) findViewById(R.id.cv_contact);

        list=getContactList();
        tempList=list;
        adapter=new ContactAdapter(list,this);
        adapter.setmChipsView(cvContact);
        rcContact.setLayoutManager(new LinearLayoutManager(this));
        rcContact.setAdapter(adapter);

        //chipsView Listener
        chipsViewListner();
    }

    private void chipsViewListner() {

        cvContact.setChipsListener(new ChipsView.ChipsListener() {
            @Override
            public void onChipAdded(ChipsView.Chip chip) {
                for(ChipsView.Chip chipItem : cvContact.getChips()){
                    Log.e("vvv-chipadd: ", "chip: "+chipItem.toString());
                }
            }

            @Override
            public void onChipDeleted(ChipsView.Chip chip) {

            }

            @Override
            public void onTextChanged(CharSequence text) {
                Log.e("vvv-TextChanged :", text.toString());
                adapter.filterItem(text);
            }

            @Override
            public boolean onInputNotRecognized(String text) {
                Log.e("vvv-NotRecognized :", text);
                return false;
            }
        });

    }

   /* protected void doFilter(CharSequence text){
        List<Contact> newList=wordSearch(tempList,text);

        list.clear();
        adapter.notifyDataSetChanged();
        for(Contact c : newList){
            list.add(c);
        }
        adapter.notifyDataSetChanged();
    }
    protected List<Contact> wordSearch(List<Contact> list,CharSequence query){
        List<Contact> wordsClone=new ArrayList<>();
        for(Contact contact : list){
            if(contact.getName().matches("(?i)("+query+ ").*" )){
                wordsClone.add(contact);
            }
        }
        return wordsClone;
    }*/

    public List<Contact> getContactList(){
        List<Contact> list=new ArrayList<>();
        /*for(int i=0;i<10;i++){
            list.add(new Contact("099 42 77 76", "Rathana "+i));
        }*/
        list.add(new Contact("","john@doe.com"));
        list.add(new Contact("","at@doodle.com"));
        list.add(new Contact("","asd@qwe.de"));
        list.add(new Contact("","verylongaddress@verylongserver.com"));
        list.add(new Contact("","thisIsMyEmail@address.com"));
        list.add(new Contact("","test@testeration.de"));
        list.add(new Contact("","short@short.com"));
        list.add(new Contact("","rathana07@gmail.com"));
        list.add(new Contact("","ornranny@gmail.com"));
        list.add(new Contact("","pirang@edu.com"));
        return list;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
