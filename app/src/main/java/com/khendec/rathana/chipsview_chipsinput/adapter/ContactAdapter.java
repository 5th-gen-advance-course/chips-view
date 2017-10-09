package com.khendec.rathana.chipsview_chipsinput.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khendec.rathana.chipsview_chipsinput.R;
import com.khendec.rathana.chipsview_chipsinput.entity.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ratha on 09-Oct-17.
 */

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private Context context;
    private List<Contact> list;
    public ContactAdapter(List<Contact> list, Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.contactImage.setImageResource(R.drawable.the_rock);
        holder.contactName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.civ_contact_image)
        public CircleImageView contactImage;
        @BindView(R.id.tv_contact_name)
        public TextView contactName;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(context,itemView);


        }
    }
}
