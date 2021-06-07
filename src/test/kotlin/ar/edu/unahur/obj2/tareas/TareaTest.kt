package ar.edu.unahur.obj2.tareas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import io.kotest.matchers.doubles.plusOrMinus

class TareaTest : DescribeSpec({
  describe("Tarea") {

    val empleado1 = Trabajador(400.00)
    val empleado2 = Trabajador(400.00)
    val empleado3 = Trabajador(500.00)
    val responsable1 = Trabajador(600.00)
    val responsable2 = Trabajador(1000.00)

    val tarea1 = TareaSimple(24.5, 25099.99, responsable1)
    val tarea2 = TareaSimple(18.0,20000.00,responsable1)

    var tareaCompuesta = TareaIntegracion(responsable2)

    tarea1.asignarEmpleado(empleado1)
    tarea1.asignarEmpleado(empleado2)

    tarea2.asignarEmpleado(empleado3)

    tareaCompuesta.agregarTarea(tarea1)
    tareaCompuesta.agregarTarea(tarea2)

    describe("Nóminas de empleados") {

      describe("tarea simple") {
        it("Consultar nómina de una tarea") {
          tarea1.nominaDeEmpleados().shouldBe(kotlin.Unit)
        }
      }
      describe("tarea compuesta") {
        it("Consultar nómina de tarea compuesta") {
          tareaCompuesta.nominaDeEmpleados().shouldBe(kotlin.Unit)
        }
      }
    }

    describe("Horas necesarias para finalizar tarea"){
      describe("Tareas simples"){
        it("4.25 hs para una primera tarea") {
          tarea1.horasNecesarias().shouldBe(12.25)
        }
        it("18 hs. para la finalizar la segunda tarea") {
          tarea2.horasNecesarias().shouldBe(18.0)
        }
      }
      describe("Tarea compuesta"){
        it("34.25 hs. para una tarea compuesta "){
          tareaCompuesta.horasNecesarias().shouldBe(34.25)
        }
      }
    }
    describe("requerimiento 3"){
      describe("tarea simple"){
        it("44699.99 es el costo de una tarea") {
          tarea1.costoTarea().shouldBe(44699.99 plusOrMinus 0.01)
        }
      }
    }
  }
})

