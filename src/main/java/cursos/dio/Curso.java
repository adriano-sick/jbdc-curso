package cursos.dio;

public class Curso {
    int id;
    String nome;
    float duracaoHoras;

    public Curso(int id, String nome, float duracaoHoras) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, float duracaoHoras) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(float duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id = " + id +
                ", nome = '" + nome + '\'' +
                ", duracaoHoras = " + duracaoHoras +
                '}';
    }
}
