package com.khendec.rathana.chipsview_chipsinput.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doodle.android.chips.ChipsView;
import com.khendec.rathana.chipsview_chipsinput.R;
import com.khendec.rathana.chipsview_chipsinput.entity.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by ratha on 09-Oct-17.
 */

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private Context context;
    private List<Contact> list;
    private ChipsView mChipsView;
    private List<Contact> tempList;

    public ChipsView getmChipsView() {
        return mChipsView;
    }

    public void setmChipsView(ChipsView mChipsView) {
        this.mChipsView = mChipsView;
    }

    public ContactAdapter(List<Contact> list, Context context){
        this.list=list;
        this.tempList=new ArrayList<>(list);
        this.context=context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        //holder.contactImage.setImageResource(R.drawable.the_rock);
        holder.contactName.setText(list.get(position).getName());
        Glide.with(context)
                .load(list.get(position).getImage())
                .into(holder.contactImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterItem(CharSequence text) {
        list.clear();
        if(TextUtils.isEmpty(text)){
            list.addAll(tempList);
            Log.e("vvv-filter : " , list.toString());
            Log.e("vvv-temp : " , tempList.size()+"");
        }else{
            for(Contact con: tempList){
                if(con.getName().contains(text)){
                    list.add(con);
                }
            }

            Log.e("vvv-filter : " , list.toString());
        }
        notifyDataSetChanged();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public CircleImageView contactImage;
        public TextView contactName;
        private CheckBox chSelection;
        public ContactViewHolder(View itemView) {
            super(itemView);
            contactImage= (CircleImageView) itemView.findViewById(R.id.civ_contact_image);
            contactName= (TextView) itemView.findViewById(R.id.tv_contact_name);
            chSelection= (CheckBox) itemView.findViewById(R.id.ch_selection);
            //register events
            chSelection.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Contact con=list.get(getAdapterPosition());
            Uri img=Uri.parse(con.getImage());
            com.doodle.android.chips.model.Contact contact=new com.doodle.android.chips.model.Contact(
                    null,null,null,
                    con.getName(),img);

            switch (v.getId()){
                case R.id.ch_selection: {
                    if(chSelection.isChecked()){
                        boolean indelibe= Math.random()>0.8f;

                        getmChipsView().addChip(con.getName(),img,contact,indelibe);
                        Log.e("vvvv","checked");
                    }else {
                        getmChipsView().removeChipBy(contact);
                        Log.e("vvvv","unchecked");
                    }
                    break;
                }
            }
        }
    }
}
