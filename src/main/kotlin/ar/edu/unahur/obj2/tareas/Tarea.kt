package ar.edu.unahur.obj2.tareas

import kotlin.math.roundToInt

abstract class  Tarea (val  responsable :  Trabajador) {
    abstract fun  nominaDeEmpleados ()
    abstract fun  horasNecesarias(): Double
    abstract fun  costoTarea (): Double
}

class TareaSimple( val horasEstimadas :  Double, val costoInfraestructura :  Double, responsable :  Trabajador): Tarea (responsable) {

    val empleadosAsignados = mutableListOf < Trabajador > ()

    override fun nominaDeEmpleados() {
        println ( "Nómina de empleados: " )
        empleadosAsignados.forEach { println (it) }
        println ( "Responsable: " + responsable)
    }

    override fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados()

    override fun costoTarea() =  horasNecesarias() * sueldoPromedioPorHora() + horasEstimadas * responsable.cuantoCobraPorHora + costoInfraestructura

    fun  cantidadDeEmpleados () = empleadosAsignados.size

    fun  asignarEmpleado ( nuevoEmpleado :  Trabajador ) { empleadosAsignados.add (nuevoEmpleado) }

    fun  sueldoPromedioPorHora (): Double {
        var sumatoria :  Double  =  0.0
        empleadosAsignados.forEach {sumatoria += it.cuantoCobraPorHora}
        return (sumatoria / cantidadDeEmpleados ())
    }
}

class TareaIntegracion(responsable :  Trabajador): Tarea(responsable) {

    val subTareas = mutableListOf < Tarea>()

    override fun nominaDeEmpleados() {
        println("Nómina general de empleados: ")
        subTareas.forEach { it.nominaDeEmpleados() }
        println("Responsable de la integración: " + responsable)
    }

    override fun horasNecesarias() = this.sumaTotalHoras() + this.adicionalPorCantidadDeTareas()

    override fun costoTarea() = this.sumaTotalDeCostos() * 1.03

    fun adicionalPorCantidadDeTareas() = ((this.sumaTotalHoras() / 8).roundToInt()).toDouble()

    fun sumaTotalHoras() = subTareas.sumByDouble { it.horasNecesarias() }

    fun sumaTotalDeCostos() = subTareas.sumByDouble{ it.costoTarea()}

    fun agregarTarea(nuevaTarea: Tarea) = subTareas.add(nuevaTarea)
}

class  Trabajador (var cuantoCobraPorHora :  Double)


