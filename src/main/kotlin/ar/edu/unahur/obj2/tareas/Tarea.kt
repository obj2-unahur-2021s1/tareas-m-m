package ar.edu.unahur.obj2.tareas

class Tarea(var horasRequeridas: Double){
    val trabajadoresEnLaTarea = mutableListOf<Trabajador>()

    var yaSeAsignoAUnResponsabe = false

    fun nominaDeEmpleados() = trabajadoresEnLaTarea.size

    fun agregarUnTrabajador(trabajadorAAgregar: Trabajador){
        if(trabajadorAAgregar.sirveParaHacerLaTarea()){
            trabajadoresEnLaTarea.add(trabajadorAAgregar)
        }
        else if(!trabajadorAAgregar.sirveParaHacerLaTarea() and !yaSeAsignoAUnResponsabe){
            trabajadoresEnLaTarea.add(trabajadorAAgregar)
            yaSeAsignoAUnResponsabe = true
        }

    }
}



//pensando seriamente en que deberia ser inteface
abstract class Trabajador(var cuantoCobraPorHora: Int){
    abstract fun sirveParaHacerLaTarea(): Boolean
}
class Empleado(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora) {
    override fun sirveParaHacerLaTarea() = true
}
class Responsable(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora){
    override fun sirveParaHacerLaTarea() = false
}
