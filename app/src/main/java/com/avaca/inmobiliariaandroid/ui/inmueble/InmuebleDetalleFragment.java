package com.avaca.inmobiliariaandroid.ui.inmueble;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avaca.inmobiliariaandroid.R;
import com.avaca.inmobiliariaandroid.databinding.InmuebleDetalleFragmentBinding;
import com.avaca.inmobiliariaandroid.modelo.Inmueble;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class InmuebleDetalleFragment extends Fragment {

    private InmuebleDetalleViewModel mViewModel;
    private InmuebleDetalleFragmentBinding binding;

    public static InmuebleDetalleFragment newInstance() {
        return new InmuebleDetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=InmuebleDetalleFragmentBinding.inflate(inflater, container, false);
        View context=binding.getRoot();
        mViewModel=new ViewModelProvider(this).get(InmuebleDetalleViewModel.class);
        inicializar();
        mViewModel.setInmuebleMT(getArguments());
        return context;
    }

    public void inicializar(){
        mViewModel.getInmuebleMT().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                Glide.with(getContext())
                        .load(inmueble.getImagen())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(binding.imInmuebleDetalle);
                binding.tvCodigoDetalle.setText(inmueble.getIdInmueble()+"");
                binding.tvAmbientesDetalle.setText(inmueble.getAmbientes()+"");
                binding.tvDireccionDetalle.setText(inmueble.getDireccion().toString());
                binding.tvPrecioDetalle.setText(inmueble.getPrecio()+"");
                binding.tvUsoDetalle.setText(inmueble.getUso().toString());
                binding.tvTipoDetalle.setText(inmueble.getTipo().toString());
                binding.cbDisponibleDetalle.setChecked(inmueble.isEstado());
                binding.cbDisponibleDetalle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewModel.actualizarEstado(binding.cbDisponibleDetalle.isChecked());
                    }
                });

            }
        });
    }

}