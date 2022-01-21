<template>
  <li>
    <router-link tag="a" active-class="is-active" :to="to">
      <slot></slot>
    </router-link>
  </li>
</template>

<script>
export default {
  name: "MenuItem",
  props: {
    to: {
      type: String,
      default: '/'
    }
  }
}
</script>