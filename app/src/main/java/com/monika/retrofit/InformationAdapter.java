package com.monika.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {

    private List<RetrofitModel> models;
    private Context mContext;

    public InformationAdapter(List<RetrofitModel> models) {
        this.models=models;
    }

    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext ();
        LayoutInflater layoutInflater=LayoutInflater.from ( parent.getContext () );
        View view=layoutInflater.inflate ( R.layout.recycler_view, parent, false );
        return new InformationViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(final InformationAdapter.InformationViewHolder holder, int position) {
        final RetrofitModel model=models.get ( position );
        holder.name.setText ( model.getName () );
        holder.realname.setText ( model.getRealname () );
        holder.team.setText ( model.getTeam () );
        holder.firstappearance.setText ( model.getFirstappearance () );
        holder.createdby.setText ( model.getCreatedby () );
        holder.publisher.setText ( model.getPublisher () );
        holder.bio.setText ( model.getBio () );

        Glide.with ( mContext ).load ( model.getImageurl () ).into ( holder.imageUrl );

    }

    @Override
    public int getItemCount() {
        return models.size ();
    }

    class InformationViewHolder extends RecyclerView.ViewHolder {

        TextView name, realname, team, firstappearance, createdby, publisher, bio;
        ImageView imageUrl;

        public InformationViewHolder(@NonNull View itemView) {
            super ( itemView );

            name=itemView.findViewById ( R.id.recycler_view_name );
            realname=itemView.findViewById ( R.id.recycler_view_real_name );
            team=itemView.findViewById ( R.id.recycler_view_team );
            firstappearance=itemView.findViewById ( R.id.recycler_view__first_appearance );
            createdby=itemView.findViewById ( R.id.recycler_view_createdby );
            publisher=itemView.findViewById ( R.id.recycler_view_publisher );
            bio=itemView.findViewById ( R.id.recycler_view_bio );
            imageUrl=itemView.findViewById ( R.id.recycler_view_image_view );

        }
    }

}
