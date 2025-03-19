package com.example.proye;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {
    private final List<Personaje> personajes;

    public PersonajeAdapter(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        holder.bind(personajes.get(position));
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView nameTextView;
        private final TextView roleTextView;
        private final TextView regionTextView;
        private final TextView dificultadTextView;
        private final TextView costoTextView;
        private final TextView fechaLanzamientoTextView;
        private final TextView habilidadPrincipalTextView;
        private final TextView vidaBaseTextView;
        private final TextView manaBaseTextView;
        private final TextView esRangoTextView;
        private final TextView historiaTextView;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            roleTextView = itemView.findViewById(R.id.roleTextView);
            regionTextView = itemView.findViewById(R.id.regionTextView);
            dificultadTextView = itemView.findViewById(R.id.dificultadTextView);
            costoTextView = itemView.findViewById(R.id.costoTextView);
            fechaLanzamientoTextView = itemView.findViewById(R.id.fechaLanzamientoTextView);
            habilidadPrincipalTextView = itemView.findViewById(R.id.habilidadPrincipalTextView);
            vidaBaseTextView = itemView.findViewById(R.id.vidaBaseTextView);
            manaBaseTextView = itemView.findViewById(R.id.manaBaseTextView);
            esRangoTextView = itemView.findViewById(R.id.esRangoTextView);
            historiaTextView = itemView.findViewById(R.id.historiaTextView);

            // Ocultar detalles inicialmente
            regionTextView.setVisibility(View.GONE);
            dificultadTextView.setVisibility(View.GONE);
            costoTextView.setVisibility(View.GONE);
            fechaLanzamientoTextView.setVisibility(View.GONE);
            habilidadPrincipalTextView.setVisibility(View.GONE);
            vidaBaseTextView.setVisibility(View.GONE);
            manaBaseTextView.setVisibility(View.GONE);
            esRangoTextView.setVisibility(View.GONE);
            historiaTextView.setVisibility(View.GONE);

            // Expandir/colapsar detalles al hacer clic
            itemView.setOnClickListener(v -> {
                boolean isExpanded = regionTextView.getVisibility() == View.VISIBLE;
                regionTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                dificultadTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                costoTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                fechaLanzamientoTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                habilidadPrincipalTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                vidaBaseTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                manaBaseTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                esRangoTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
                historiaTextView.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
            });
        }

        public void bind(Personaje personaje) {
            imageView.setImageResource(personaje.getImagen());
            nameTextView.setText(personaje.getNombre());
            roleTextView.setText("Rol: " + personaje.getRol());
            regionTextView.setText("Región: " + personaje.getRegion());
            dificultadTextView.setText("Dificultad: " + personaje.getDificultad());
            costoTextView.setText("Costo: " + personaje.getCosto());
            fechaLanzamientoTextView.setText("Lanzamiento: " + personaje.getFechaLanzamiento());
            habilidadPrincipalTextView.setText("Habilidad Principal: " + personaje.getHabilidadPrincipal());
            vidaBaseTextView.setText("Vida Base: " + personaje.getVidaBase());
            manaBaseTextView.setText("Mana Base: " + personaje.getManaBase());
            esRangoTextView.setText("Es de Rango: " + (personaje.isEsRango() ? "Sí" : "No"));
            historiaTextView.setText("Historia: " + personaje.getHistoria());
        }
    }
}