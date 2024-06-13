<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view/>
</template>

<script>
export default{

    created(){

      const user = sessionStorage.getItem('setUser')

      console.log(JSON.parse(user)) 

        if(user)
        {
             // console.log( user,this.base64(user) )
              console.log(" 사용자 정보 잇음222 ") ; 
              this.$store.commit('setUser' , JSON.parse(user) )
        }
        else{
              console.log(" 사용자 정보 없음 ") ; 
        }
    },
    /*methods : {
      base64(user)  // 암호화 
      {
          return JSON.parse(decodeURIComponent(window.atob(user)))
      }
    }*/
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
