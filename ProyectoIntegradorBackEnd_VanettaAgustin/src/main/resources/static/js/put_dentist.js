window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del estudiante
    const formulario = document.querySelector('#update_dentist_form');
    formulario.addEventListener('submit', function (event) {
        let dentistId = document.querySelector('#dentist_id').value;

        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#dentist_id').value,
            name: document.querySelector('#nombre').value,
            lastname: document.querySelector('#apellido').value,
            register: document.querySelector('#register').value,

        };

        //invocamos utilizando la función fetch la API estudiantes con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = '/dentists/update';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
    //se encarga de llenar el formulario con los datos del estudiante
    //que se desea modificar
    function findBy(id) {
          const url = '/dentists'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let dentist = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#nombre').value = dentist.name;
              document.querySelector('#apellido').value = dentist.lastname;
              document.querySelector('#register').value = dentist.register;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_dentist_updating').style.display = "block";
          }).catch(error => {
              console.log(error)
          })
      }