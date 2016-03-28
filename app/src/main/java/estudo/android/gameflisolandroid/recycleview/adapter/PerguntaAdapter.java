package estudo.android.gameflisolandroid.recycleview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jordy on 26/03/16.
 */
public class PerguntaAdapter extends RecyclerView.Adapter<PerguntaAdapter.PerguntaViewHolder> {
    @Override
    public PerguntaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PerguntaViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class PerguntaViewHolder extends RecyclerView.ViewHolder
    {


        public PerguntaViewHolder(View itemView) {
            super(itemView);
        }
    }
}
