<template>
  <div>
    <!-- <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#0099ff" fill-opacity="1" d="M0,192L48,197.3C96,203,192,213,288,229.3C384,245,480,267,576,250.7C672,235,768,181,864,181.3C960,181,1056,235,1152,234.7C1248,235,1344,181,1392,154.7L1440,128L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path></svg> -->
    <div class="user">
      <i class="fa fa-user"></i>
      <div class="head">{{ head }}</div>
    </div>
    <div class="container">
      <div class="box login" ref="login">
        <div class="form-content">
          <div class="avtar">
            <div class="pic"><img src="../../img/1.jpg" alt="" /></div>
          </div>
          <h1>Welcome back</h1>
          <form action="#" class="form">
            <div>
              <i class="fa fa-user-o"></i>
              <input type="text" placeholder="username" />
            </div>
            <div>
              <i class="fa fa-key"></i>
              <input type="password" placeholder="password" />
            </div>
            <div class="btn">
              <button>login</button>
            </div>
          </form>
          <p class="btn-something">
            Don't have an account ?
            <span class="signupbtn" @click="clicksignup">signup</span>
          </p>
        </div>
      </div>
      <div class="box signup" ref="signup">
        <div class="form-content">
          <div class="avtar">
            <div class="pic"><img src="../../img/2.jpg" alt="" /></div>
          </div>
          <h1>Let's get started</h1>
          <form action="#" class="form">
            <div>
              <i class="fa fa-user-o"></i>
              <input type="text" placeholder="username" />
            </div>
            <div>
              <i class="fa fa-key"></i>
              <input type="password" placeholder="password" />
            </div>
            <div>
              <i class="fa fa-key"></i>
              <input type="password" placeholder="confirm password" />
            </div>
            <div class="btn">
              <button>signup</button>
            </div>
          </form>
          <p class="btn-something">
            Already have an account ?
            <span class="loginbtn" @click="clicklogin">login</span>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      head: "account login",
    };
  },
  methods: {
    clicklogin() {
      this.head = "account login";
      this.$refs.login.style.transform = "rotateY(0deg)";
      this.$refs.signup.style.transform = "rotateY(-180deg)";
    },
    clicksignup() {
      this.head = "create account";
      this.$refs.login.style.transform = "rotateY(180deg)";
      this.$refs.signup.style.transform = "rotateY(0deg)";
    },
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

body {
  background-color: #f0f5f5;
}

body::before {
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: #3399ff;
  clip-path: circle(20% at 100% 0);
}

.container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 20rem;
  height: 28rem;
  perspective: 1500px;
  -webkit-perspective: 1500px;
  -moz-perspective: 1500px;
}

.box {
  position: absolute;
  top: 0;
  left: 0;
  width: 20rem;
  height: 28rem;
  border-radius: 10px;
  cursor: pointer;
  backface-visibility: hidden;
  transition: all 0.5s;
  user-select: none;
}

.signup {
  /* background-color: blue; */
  transform: rotateY(-108deg);
}

.container .form-content {
  position: relative;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  box-shadow: 0 0 1px #3399ff;
  border-radius: 30px;
  background-color: #fff;
}

.container .form-content .avtar {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}

.container .form-content .avtar .pic {
  position: relative;
  width: 80px;
  height: 80px;
  overflow: hidden;
  border-radius: 50%;
  border: 1px solid #3399ff;
}

.container .form-content .avtar .pic img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.container .form-content h1 {
  font-size: 1.6rem;
}

.container .form {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.container .form input {
  width: 16rem;
  padding: 0.8rem;
  padding-left: 3rem;
  outline: none;
  border: none;
  border-radius: 15px;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.2);
  margin: 5px;
}

.container .form div {
  position: relative;
}

.container .form div .fa {
  position: absolute;
  top: 18px;
  left: 25px;
}

.container .form .btn {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  margin-top: 10px;
}

.container .form .btn button {
  text-transform: uppercase;
  padding: 8px;
  border: none;
  outline: none;
  background-color: #0066ff;
  color: #fff;
  width: 12rem;
  border-radius: 30px;
  cursor: pointer;
}

.container .btn-something {
  color: #888;
  font-size: 14px;
}

.container .btn-something span {
  color: #0066ff;
  cursor: pointer;
  font-weight: 500;
}

svg {
  position: absolute;
  bottom: 0;
  z-index: -1;
}

.user {
  position: absolute;
  top: 16rem;
  left: 5rem;
}

.user .fa-user {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 5rem;
  color: #0066ff;
}

.user .head {
  font-size: 1.6rem;
  text-transform: uppercase;
  user-select: none;
  text-shadow: 1px 1px 1px rgba(16, 16, 16, 0.1),
    1px 2px 1px rgba(16, 16, 16, 0.1), 1px 3px 1px rgba(16, 16, 16, 0.1),
    1px 4px 1px rgba(16, 16, 16, 0.1), 1px 5px 1px rgba(16, 16, 16, 0.1),
    1px 6px 1px rgba(16, 16, 16, 0.1), 1px 7px 1px rgba(16, 16, 16, 0.1),
    1px 8px 1px rgba(16, 16, 16, 0.1);
}
</style>