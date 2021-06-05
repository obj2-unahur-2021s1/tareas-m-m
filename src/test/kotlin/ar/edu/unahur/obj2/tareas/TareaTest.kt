package ar.edu.unahur.obj2.tareas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.doubles.plusOrMinus

class TareaTest : DescribeSpec({
  describe("Tarea") {

    val empleado1 = Trabajador(400)
    val empleado2 = Trabajador(400)
    val responsable1 = Trabajador(600)
    val responsable2 = Trabajador(1000)

    var tarea1 = TareaSimple(24.5, 25099.99, responsable1)
    var tareaCompuesta = TareaIntegracion(34.0, 30150.99, responsable2)

    tarea1.asignarEmpleado(empleado1)
    tarea1.asignarEmpleado(empleado2)

    tareaCompuesta.agregarTarea(tarea1)

    describe("requerimiento 1"){

      describe("tarea simple"){
        it("Consultar nómina de una tarea") {
          tarea1.nominaDeEmpleados().shouldBe(kotlin.Unit)
        }


      }
      describe("tarea compuesta"){}
    }

    describe("requerimiento 2"){
      describe("tarea simple"){
        it("4.25 horas necesarias para finalizar la tarea") {
          tarea1.horasNecesarias().shouldBe(12.25)
        }
      }
      describe("tarea compuesta"){}
    }
    describe("requerimiento 3"){
      describe("tarea simple"){
        it("44699.99 es el costo de una tarea") {
          tarea1.costoTarea().shouldBe(44699.99 plusOrMinus 0.01)
        }
      }
      describe("tarea compuesta"){}
    }

  }
})

