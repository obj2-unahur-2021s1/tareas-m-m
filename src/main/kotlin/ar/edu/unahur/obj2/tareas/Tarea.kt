package ar.edu.unahur.obj2.tareas

class Tarea(var horasRequeridas: Double){
    val trabajadoresEnLaTarea = mutableListOf<Trabajador>()

    fun nominaDeEmpleados() = trabajadoresEnLaTarea.size

    fun agregarUnTrabajador(trabajadorAAgregar: Trabajador) = trabajadoresEnLaTarea.add(trabajadorAAgregar)
}

//pensando seriamente en que deberia ser inteface
open class Trabajador(var cuantoCobraPorHora: Int){}

class Empleado(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora) {}

class Responsable(cuantoCobraPorHora: Int): Trabajador(cuantoCobraPorHora){}
