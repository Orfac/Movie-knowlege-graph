<template>
  <div class="sidebar-page ml-5">
    <aside class="menu">
      <p class="menu-label">
        Меню
      </p>
      <ul class="menu-list">
        <li><router-link active-class="is-active" to="/">Стартовая страница</router-link></li>
        <li><router-link active-class="is-active" to="/all">Показать весь граф</router-link></li>
        <li><router-link to="">Персональные рекомендации</router-link></li>
        <li><router-link to=""></router-link></li>
      </ul>
    </aside>
  </div>
</template>

<script>
export default {
  name: "Menu"
}
</script>

<style scoped>

</style>