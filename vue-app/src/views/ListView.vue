<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 목록</h1>
    <div class="btn-group">
      <router-link to="/user/save" class="btn btn-primary">사용자 추가</router-link>
    </div>
    <table class="table table-hover mt-3">
      <thead class="table-dark">
        <tr>
          <th>이름11</th>
          <th>이메일33</th>
          <th>가입날짜</th>
        </tr>
      </thead>
      <tbody>
        <tr class="cursor-pointer" v-for="row in result" v-bind:key="row.no" v-on:click="href(row)">
          <td>{{ row.name }}</td>
          <td>{{ row.email }}</td>
          <td>{{ row.regdate }} </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>


<script>

import axios from 'axios'

export default {
  name: 'ListView',
  data() {
    return {
      result: []
    }
  },
  created() {
    console.log('List', this.$store.state.user)

    console.log(sessionStorage.getItem('setUser'))
    console.log(process.env.VUE_APP_BASEURL )

    this.getData()
  },
  methods: {
    getData() {
      axios
        .post('http://localhost:8080/findAll')
        .then((response) => (this.result = response.data.result))
        .catch((error) => console.log(error))
    }, 

 
    href(row) {
      // query  > http://localhost:8800/user/findById?name=사용자&pwd=1
      // params > http://localhost:8800/user/findById/사용자/1
      // index.js > path: '/user/findById/:name/:pwd'
      console.log(row)
      //this.$store.commit('setUser', row)
      // sessionStorage.setItem('setUser', this.base64(row))
      //store.commit('setUser',row)
      
      this.$store.commit('setUser', row)
      sessionStorage.setItem('setUser', JSON.stringify( row )  )
      this.$router.push({ name: 'SelectView'  })
    }
 
  }
}
</script>


<style scoped>
.cursor-pointer {
  cursor: pointer;
}
</style>