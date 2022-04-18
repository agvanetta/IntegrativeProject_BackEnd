import React, { Component } from 'react';
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEdit, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import { Modal, ModalBody, ModalFooter, ModalHeader } from 'reactstrap';
import "./Home.css";

const urlTodos="http://localhost:8080/dentists/lists";
const urlPost="http://localhost:8080/dentists/register";
const urlDelete="http://localhost:8080/dentists/";
const urlPut="http://localhost:8080/dentists/update";


class Dentist extends Component {
state={
  data:[],
  modalInsertar: false,
  modalEliminar: false,
  form:{
    id: '',
    name: '',
    lastname: '',
    register: '',
    tipoModal: ''
  },
  formv2:{
    name: '',
    lastname: '',
    register: '',
    tipoModal: ''
  }
}

peticionGet=()=>{
axios.get(urlTodos).then(response=>{
    console.log(response)
  this.setState({data: response.data});
}).catch(error=>{
  console.log(error.message);
})
}

peticionPost=async()=>{
  delete this.state.form.id;
 await axios.post(urlPost,this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  }).catch(error=>{
    console.log(error.message);
  })
}

peticionPut=()=>{
  axios.put(urlPut, this.state.form).then(response=>{
    this.modalInsertar();
    this.peticionGet();
  })
}

peticionDelete=()=>{
  axios.delete(urlDelete+this.state.form.id).then(response=>{
    this.setState({modalEliminar: false});
    this.peticionGet();
  })
}

modalInsertar=()=>{
  this.setState({modalInsertar: !this.state.modalInsertar});
}

seleccionarCliente=(data)=>{
  this.setState({
    tipoModal: 'actualizar',
    form: {
      id: data.id,
      nombre: data.nombre,
      apellido: data.apellido,
    }
  })
}

handleChange=async e=>{
e.persist();
await this.setState({
  form:{
    ...this.state.form,
    [e.target.name]: e.target.value
  }
});
console.log(this.state.form);
}

  componentDidMount() {
    this.peticionGet();
  }
  

  render(){
    const {form}=this.state;
  return (
    <div className="App" id="home">
    <br /><br /><br />
  <button className="btn btn-success" id="btn" onClick={()=>{this.setState({form: null, tipoModal: 'insertar'}); this.modalInsertar()}}>Add Dentist</button>
  <br /><br />
    <table className="table" id="tablev2">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Lastname</th>
          <th>Register</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
          
        {this.state.data.map((data,i)=>{
          return(
            <tr key={i}>
          <td>{data.id}</td>
          <td>{data.name}</td>
          <td>{data.lastname}</td>
          <td>{data.register}</td>
          <td>
                <button className="btn btn-primary" id="btn"  onClick={()=>{this.seleccionarCliente(data); this.modalInsertar()}}><FontAwesomeIcon icon={faEdit}/></button>
                {"   "}
                <button className="btn btn-danger" onClick={()=>{this.seleccionarCliente(data); this.setState({modalEliminar: true})}}><FontAwesomeIcon icon={faTrashAlt}/></button>
                </td>
          </tr>
          )
        })}
      </tbody>
    </table>



    <Modal isOpen={this.state.modalInsertar}>
                <ModalHeader style={{display: 'block'}}>
                  <span style={{float: 'right'}} onClick={()=>this.modalInsertar()}>x</span>
                </ModalHeader>
                <ModalBody>
                  <div className="form-group">
                    <label htmlFor="id">ID</label>
                    <input className="form-control" type="text" name="id" id="id" readOnly onChange={this.handleChange} value="Default"/>
                    <br />
                    <label htmlFor="nombre">Name</label>
                    <input className="form-control" type="text" name="name" id="name" onChange={this.handleChange} value={form?form.name: ''}/>
                    <br />
                    <label htmlFor="nombre">Lastname</label>
                    <input className="form-control" type="text" name="lastname" id="lastname" onChange={this.handleChange} value={form?form.lastname: ''}/>
                    <br />
                    <label htmlFor="nombre">Register</label>
                    <input className="form-control" type="text" name="register" id="register" onChange={this.handleChange} value={form?form.register: ''}/>
                    <br />
                  </div>
                </ModalBody>

                <ModalFooter>
                  {this.state.tipoModal==='insertar'?
                    <button className="btn btn-success" onClick={()=>this.peticionPost()}>
                    Insert
                  </button>: <button className="btn btn-primary" onClick={()=>this.peticionPut()}>
                    Update
                  </button>
  }
                    <button className="btn btn-danger" onClick={()=>this.modalInsertar()}>Cancel</button>
                </ModalFooter>
          </Modal>


          <Modal isOpen={this.state.modalEliminar}>
            <ModalBody>
            Are you sure you want to delete?
            </ModalBody>
            <ModalFooter>
              <button className="btn btn-danger" onClick={()=>this.peticionDelete()}>Yes</button>
              <button className="btn btn-secundary" onClick={()=>this.setState({modalEliminar: false})}>No</button>
            </ModalFooter>
          </Modal>
  </div>
  );
}
}
export default Dentist;
