package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas: Double, val costoInfraestructura: Double, val responsable: Trabajador) {

    val empleadosAsignados = mutableListOf<Trabajador>()    // ver si se puede pasar por parámetro

    fun sueldoPromedioPorHora() : Double {
        var sumatoria : Double = 0.0
        empleadosAsignados.forEach { sumatoria += it.cuantoCobraPorHora }
        return (sumatoria / cantidadDeEmpleados())
    }

    fun nominaDeEmpleados() {
        println("Nómina de empleados:")
        empleadosAsignados.forEach {
            println(it)
        }
        println("Responsable: " + responsable)
    }

    fun asignarEmpleado(nuevoEmpleado: Trabajador) {
        empleadosAsignados.add(nuevoEmpleado)
    }

    fun cantidadDeEmpleados() = empleadosAsignados.size

    fun horasNecesarias() = horasEstimadas / this.cantidadDeEmpleados()

    fun costoTarea() = horasNecesarias() * sueldoPromedioPorHora() + horasEstimadas * responsable.cuantoCobraPorHora + costoInfraestructura
}


class Trabajador(var cuantoCobraPorHora: Int)

