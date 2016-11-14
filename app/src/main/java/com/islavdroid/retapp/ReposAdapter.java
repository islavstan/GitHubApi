package com.islavdroid.retapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.islavdroid.retapp.model.GitHubRepo;

import java.util.List;


    public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    private List<GitHubRepo>repos;
    private int rowLayout;
    private Context context;

    public ReposAdapter(List<GitHubRepo> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public ReposAdapter.ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposAdapter.ReposViewHolder holder, int position) {
holder.repoName.setText(repos.get(position).getName());
holder.repoDescr.setText(repos.get(position).getDescription());
holder.repoLanguage.setText(repos.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
    public  static class ReposViewHolder extends RecyclerView.ViewHolder{
        LinearLayout reposLayout;
        TextView repoName;
        TextView repoDescr;
        TextView repoLanguage;

        public ReposViewHolder(View itemView) {
            super(itemView);
            reposLayout = (LinearLayout)itemView.findViewById(R.id.repos_item_layout);
            repoName = (TextView)itemView.findViewById(R.id.repoName);
            repoDescr = (TextView)itemView.findViewById(R.id.repoDesc);
            repoLanguage = (TextView)itemView.findViewById(R.id.repoLanguage);
        }
    }
}
