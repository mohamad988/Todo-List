package com.mohamad988.todo_list0.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mohamad988.todo_list0.R;
import com.mohamad988.todo_list0.classes.ListClass;

import java.util.ArrayList;

/*import static com.mohamad988.todo_list0.Lists.currentNotebookId;
import static com.mohamad988.todo_list0.ShowTask.notes;*/

public class AllListsAdapter extends RecyclerView.Adapter<AllListsAdapter.ViewHolder>  {

    private ArrayList<ListClass> data;


    private OnItemClickListener mListener;
    public AllListsAdapter(ArrayList<ListClass> data){
        this.data = data;
    }

    //onItemClick
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
   @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listtt, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bookName.setText(data.get(position).name);
        holder.noOfTask.setText(" Task");
        }



    @Override
    public int getItemCount() {
        return data.size();
    }



    public   void filterList(ArrayList<ListClass> filteredList) {
        data = filteredList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView bookName;
        public TextView noOfTask;

        public ViewHolder(View itemView) {
            super(itemView);

            bookName=itemView.findViewById(R.id.name_List);
            noOfTask=itemView.findViewById(R.id.numberOfTask);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
