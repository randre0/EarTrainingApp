package randre0.com.github.eartraining;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import randre0.com.github.eartraining.databinding.ListItemResultBinding;
import randre0.com.github.eartraining.databinding.ResultsListBinding;

public class ResultsListActivity extends AppCompatActivity {

    private ResultsList mResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResults = new ResultsList(getBaseContext());
        ResultsListBinding binding = DataBindingUtil
                .setContentView(this, R.layout.results_list);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(),
                1));
        binding.recyclerView.setAdapter(new ResultAdapter(mResults.getResultsList()));
    }


    private class ResultHolder extends RecyclerView.ViewHolder {

        private ListItemResultBinding mBinding;

        private ResultHolder(ListItemResultBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            binding.setViewModel(new ResultViewModel(mResults));
        }

        public void bind(Result result) {
            mBinding.getViewModel().setResult(result);
            mBinding.executePendingBindings();
        }


    }

    private class ResultAdapter extends RecyclerView.Adapter<ResultHolder> {
        private List<Result> mResults;

        public ResultAdapter(List<Result> results)
        {
            mResults = results;
        }

        @Override
        public ResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getBaseContext());
            ListItemResultBinding binding = DataBindingUtil
                    .inflate(inflater, R.layout.list_item_result, parent, false);
            return new ResultHolder(binding);
        }

        @Override
        public void onBindViewHolder(ResultHolder holder, int position) {
            Result result = mResults.get(position);
            holder.bind(result);
        }

        @Override
        public int getItemCount(){
            return mResults.size();
        }

        public void setResults(List<Result> results) {
            mResults = results;
        }
    }



}
