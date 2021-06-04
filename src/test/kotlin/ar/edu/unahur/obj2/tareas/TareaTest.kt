package ar.edu.unahur.obj2.tareas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Tarea") {
    var tarea1 = Tarea(8.5)
    val empleado1 = Empleado(400)
    val empleado2 = Empleado(400)
    val responsable1 = Responsable(600)

    it("Consultar nómina de una tarea") {
      tarea1.asignarTrabajador(empleado1)
      tarea1.asignarTrabajador(empleado2)
      tarea1.nominaDeEmpleados().shouldBe(kotlin.Unit)    // revisar esto, porque es una salida de
                                                          // tipo String y no permite corroborar la
                                                          // lista. El enunciado no especifica cómo
                                                          // es la consulta.
    }
  }
})
