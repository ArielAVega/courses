package elearning.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cur_id")
	private Long id;
	@Column(name = "cur_nombre")
	private String nombre;
	@Column(name = "cur_duracion")
	private int duracion;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cur_profesor_id", nullable = false, 
    		    referencedColumnName = "prof_id")
	private Profesor profesor;
	
	@ManyToMany
	@JoinTable(name = "cursos_estudiantes",
			   joinColumns = @JoinColumn(name="curso_id",referencedColumnName = "cur_id"),
			   inverseJoinColumns = @JoinColumn(name="estudiante_id",referencedColumnName = "est_id")
			)
	private List<Estudiante> estudiantes;
}

