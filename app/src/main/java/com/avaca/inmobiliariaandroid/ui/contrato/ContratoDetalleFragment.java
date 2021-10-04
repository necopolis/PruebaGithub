package com.avaca.inmobiliariaandroid.ui.contrato;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avaca.inmobiliariaandroid.R;
import com.avaca.inmobiliariaandroid.databinding.ContratoDetalleFragmentBinding;
import com.avaca.inmobiliariaandroid.modelo.Contrato;

public class ContratoDetalleFragment extends Fragment {

    private ContratoDetalleViewModel mViewModel;
    private ContratoDetalleFragmentBinding binding;

    public static ContratoDetalleFragment newInstance() {
        return new ContratoDetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ContratoDetalleFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = new ViewModelProvider(this).get(ContratoDetalleViewModel.class);

        mViewModel.getcontratoMT().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                binding.tvCodigoContrato.setText(contrato.getIdContrato()+"");
                binding.tvFechaInicioContrato.setText(contrato.getFechaInicio()+"");
                binding.tvFechaFinContrato.setText(contrato.getFechaFin()+"");
                binding.tvMontoContrato.setText(contrato.getMontoAlquiler()+"");
                binding.tvInqNomContrato.setText(contrato.getInquilino().getNombre()+"");
                binding.tvInmuebleDireccion.setText(contrato.getInmueble().getDireccion()+"");
                binding.btnVerPagos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("contrato",contrato);
                        Navigation.findNavController(root).navigate(R.id.pagoFragment,bundle);
                    }
                });
            }
        });
        mViewModel.setcontratoMT(getArguments());
        return root;
    }

}